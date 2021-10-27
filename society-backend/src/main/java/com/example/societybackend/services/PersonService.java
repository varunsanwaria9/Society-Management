package com.example.societybackend.services;

import com.example.societybackend.databases.entities.Auth;
import com.example.societybackend.databases.entities.Person;
import com.example.societybackend.databases.repos.AuthRepo;
import com.example.societybackend.databases.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private AuthRepo authRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Auth> auth = authRepo.findByEmail(email);
        if(auth.isEmpty()) throw new UsernameNotFoundException("User not Found!!");
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        auth.get().getRoles().forEach(roles -> {
            authorities.add(new SimpleGrantedAuthority(roles.getRole()));
        });
        return new User(auth.get().getEmail(),auth.get().getPassword(),authorities);
    }

	public Person addUser(Person person){
		return personRepo.save(person);
	}
    public List<Person> allUsers(){
        return personRepo.findAll();
    }

	public Optional<Person> getById(String id){
		return personRepo.findById(id);
	}

	public Person updatePerson(Person person){
		return personRepo.save(person);
	}
}
