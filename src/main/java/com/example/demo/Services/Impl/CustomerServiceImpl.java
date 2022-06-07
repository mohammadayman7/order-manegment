package com.example.demo.Services.Impl;

import com.example.demo.DTO.CustomerDto;
import com.example.demo.Entity.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public Iterable<Customer> getAllStocks() {
        return customerRepository.findAll();
    }





    @Override
    public Customer save(Customer stock) {
        return customerRepository.save(stock);
    }

    @Override
    public Customer update(Long id, CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository.findById(id);

        customer.get().setEmail(customerDto.getEmail());
        customer.get().setFirstName(customerDto.getFirstName());
        customer.get().setLastName(customerDto.getLastName());
        customer.get().setPassword(customerDto.getPassword());
        customer.get().setBornAt(customerDto.getBornAt());



        Customer result = customerRepository.save(customer.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }

//    public ResponseEntity<String> singin(@RequestBody SiginInDto SigninDto){
//        if(customerRepository.existsByEmailAndPassword(SigninDto.getEmail(), SigninDto .getPassword())){
//            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//        }
//        else return  new ResponseEntity<>("User not found!.", HttpStatus.OK);
//
//    }
//
//    public ResponseEntity<?> signUp(@RequestBody SignUpDto signUpDto){
//
//        // add check for username exists in a DB
//        if(customerRepository.existsByEmail(signUpDto.getEmail())){
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
//        }


        // create user object
//        Customer customer = new Customer();
//        customer.setFirstName(signUpDto.getFirstName());
//        customer.setLastName(signUpDto.getLastName());
//        customer.setEmail(signUpDto.getEmail());
//        customer.setPassword(signUpDto.getPassword());
//
//
//
//        customerRepository.save(customer);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//
//    }
}

