package com.learn.SidClasses.Controller;

import com.learn.SidClasses.Customs_Constants.AppConstants;
import com.learn.SidClasses.Dto.UserDto;
import com.learn.SidClasses.Entities.User;
import com.learn.SidClasses.Service.UserImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserImpl uimp;

    public UserController(UserImpl uimp) {
        this.uimp = uimp;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User user){
       return ResponseEntity.status(HttpStatus.CREATED).body(uimp.create(user));
    }

    @GetMapping
    public List<UserDto> getall(@RequestParam(value="pageno",defaultValue = AppConstants.Default_page_no)int pno,
                                @RequestParam(value="pagesize",defaultValue = AppConstants.Default_page_size) int psize,
                                @RequestParam(value="sortby",defaultValue = AppConstants.Default_sortBy)String sortby){
        return uimp.getall(pno,psize,sortby);

    }
}
