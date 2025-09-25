package org.implementer.demo.investapi.rest;

import lombok.RequiredArgsConstructor;
import org.implementer.demo.investapi.dtos.CDTDTO;
import org.implementer.demo.investapi.repository.UserInvestmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/demo")
public class UserInvestmentController {

    private final UserInvestmentRepository repository;

    public UserInvestmentController(UserInvestmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getByDocument/")
    public CDTDTO getUsers(@RequestParam String id) {
        return new CDTDTO(repository.findByUserId(id.isBlank() ? null : id));
    }
}
