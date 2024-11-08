package com.iet.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.iet.dao.UserRepository;
import com.iet.pojos.Role;
import com.iet.pojos.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserTest {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepo;

	@Test
	void test() {
		assertNotNull(userRepo);
	}

	@Test
	void userTest() {
		List<User> list = List.of(
				new User("ravi", "kumar", "ravikumar@gmail.com", encoder.encode("Ravi123"), "7607890632",
						Role.ADMIN),
				new User("Shamim", "Ahemed", "shamimahemad337@gmail.com", encoder.encode("Shamim@123"), "7619908892",
						Role.ADMIN),
				new User("Rushikesh", "pachore", "rushikeshpachore2@gmail.com", encoder.encode("Rushikesh123"), "7607890633",
						Role.ADMIN),
				new User("shubham", "mahajan", "shubham@gmail.com", encoder.encode("Shubham123"), "7607890631",
						Role.ADMIN));
		userRepo.saveAll(list);
	}
}
