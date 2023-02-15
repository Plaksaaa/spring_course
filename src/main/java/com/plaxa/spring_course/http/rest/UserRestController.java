package com.plaxa.spring_course.http.rest;

import com.plaxa.spring_course.dto.PageResponse;
import com.plaxa.spring_course.dto.UserCreateEditDto;
import com.plaxa.spring_course.dto.UserFilter;
import com.plaxa.spring_course.dto.UserReadDto;
import com.plaxa.spring_course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PageResponse<UserReadDto> findAll(UserFilter userFilter, Pageable pageable) {
        Page<UserReadDto> users = userService.findAll(userFilter, pageable);
        return PageResponse.of(users);
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@Validated @RequestBody UserCreateEditDto userCreateEditDto) {
        return userService.create(userCreateEditDto);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable Long id, @Validated @RequestBody UserCreateEditDto userCreateEditDto) {
        return userService.update(id, userCreateEditDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /*@GetMapping(value = "/{id}/avatar", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] findAvatar(@PathVariable Long id) {
        return userService.findAvatar(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }*/

    @GetMapping("/{id}/avatar")
    public ResponseEntity<byte[]> findAvatar(@PathVariable Long id) {
        return userService.findAvatar(id)
                .map(content -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                        .contentLength(content.length)
                        .body(content))
                .orElseGet(ResponseEntity.notFound()::build);
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return userService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
