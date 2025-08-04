package com.learn.SidClasses;

import com.learn.SidClasses.Customs_Constants.AppConstants;
import com.learn.SidClasses.Entities.Role;
import com.learn.SidClasses.Entities.User;
import com.learn.SidClasses.Exception.ResourceAlreadyExistException;
import com.learn.SidClasses.Exception.ResourceNotFoundException;
import com.learn.SidClasses.Repository.RoleRepo;
import com.learn.SidClasses.Repository.UserRepo;
import com.learn.SidClasses.Service.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;


@SpringBootApplication
public class SidClassesApplication  {
//implements CommandLineRunner
	public static void main(String[] args) {

		SpringApplication.run(SidClassesApplication.class, args);
	}

//	private UserRepo urepo;
//	private PasswordEncoder passwordEncoder;
//	private RoleRepo rrepo;
//
//	public SidClassesApplication(UserRepo urepo, PasswordEncoder passwordEncoder, RoleRepo rrepo) {
//		this.urepo = urepo;
//		this.passwordEncoder = passwordEncoder;
//		this.rrepo=rrepo;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
////role Creation
//		Role r1=new Role();
//		r1.setRoleName("Admin");
//		Role r2=new Role();
//		r2.setRoleName("Guest");
//		rrepo.findByRoleName(AppConstants.Default_Admin).ifPresentOrElse(role->{
//			System.out.println("Already exists");
//		},()->rrepo.save(r1));
//		rrepo.findByRoleName(AppConstants.Default_Guest).ifPresentOrElse(role->{
//			System.out.println("Already exists");
//		},()->rrepo.save(r2));
//
////user creation
//		User user = new User();
//		user.setAbout("This user is our future billionaire");
//		user.setActive(true);
//		user.setName("Sidharth Bhuyan");
//		user.setEmail("sidharthbhuyan2310@gmail.com");
//		user.setCreatedAt(new Date());
//		user.setEmailVerified(true);
//		user.setPassword(passwordEncoder.encode("Sinu2"));
//		user.assignrole(r2);
//		urepo.findByEmail(user.getEmail()).ifPresentOrElse(u1->{System.out.println(user.getEmail());},()->{urepo.save(user);System.out.println("user created");});
//
//		User user1=new User();
//		user1.setAbout("This user is our future Trillionaire");
//		user1.setActive(true);
//		user1.setName("Nikuuuu");
//		user1.setEmail("Nik0608@gmail.com");
//		user1.setCreatedAt(new Date());
//		user1.setEmailVerified(true);
//		user1.setPassword(passwordEncoder.encode("nik"));
//		user1.assignrole(r1);
//		user1.assignrole(r2);
//		urepo.findByEmail(user1.getEmail()).ifPresentOrElse(u2->{System.out.println(user1.getEmail());},()->urepo.save(user1));
//	}
}
