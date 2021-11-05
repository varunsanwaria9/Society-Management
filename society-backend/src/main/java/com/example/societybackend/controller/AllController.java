package com.example.societybackend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Person;
import com.example.societybackend.databases.entities.Roles;
import com.example.societybackend.databases.models.RegisterModel;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.PersonRepo;
import com.example.societybackend.databases.repos.RolesRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "/api")
public class AllController {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private AuthRepo authRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepo rolesRepo;

    @GetMapping(path = "/refreshToken")
    public ResponseEntity<?> getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                Auth auth = authRepo.findByEmail(username).get();
                String access_token = JWT.create()
                        .withSubject(auth.getEmail())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("Roles",auth.getRoles().stream().map(roles -> {
                            return roles.getRole();
                        }).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (Exception exception){
                response.setHeader("error",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String,String> error = new HashMap<>();
                error.put("error",exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
                return new ResponseEntity<>(FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody RegisterModel registerModel){
        Optional<Roles> role = rolesRepo.findByRole("PERSON");
        if(role.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Auth auth = new Auth(registerModel.getEmail(),passwordEncoder.encode(registerModel.getPassword()),List.of(role.get()));
        Person person = new Person(registerModel.getFirst_name(),registerModel.getLast_name(), registerModel.getGender(),
                registerModel.getPhone(),registerModel.getDob(),null,List.of(),auth);
        return new ResponseEntity<>(personRepo.save(person),HttpStatus.CREATED);
    }
}
