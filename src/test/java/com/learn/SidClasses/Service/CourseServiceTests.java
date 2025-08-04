//package com.learn.SidClasses.Service;
//
//import com.learn.SidClasses.Entities.Course;
//import com.learn.SidClasses.Repository.CourseRepo;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//
//public class CourseServiceTests {
//    @InjectMocks
//    private CourseImpl cimpl;
//
//    @Mock
//    private CourseRepo crepo;
//
//    @Test
//    void byTitleTest(){
//        // Create a sample Course object
//        Course javaCourse = new Course();
//        javaCourse.setTitle("Java");
//        javaCourse.setDescription("Learn Java programming");
//
//        // Create an Optional containing the sample Course
//        Optional<Course> expectedCourse = Optional.of(javaCourse);
//
//       // Set up the mock to return the Optional when findByTitleIgnoreCase("Java") is called
//        when(crepo.findByTitleIgnoreCase("Java")).thenReturn(expectedCourse);
//
//        // Call the service method you want to test
//        Optional<Course> actualCourse = cimpl.findByTitleIgnoreCase("Java");
//
//        // Assert that the returned Optional is not null
//        assertNotNull(actualCourse);
//
//
//       // You might also want to assert that the Optional contains the expected Course
//        assertEquals(expectedCourse, actualCourse);
//        // Or assert specific properties of the returned Course
//        actualCourse.ifPresent(course -> assertEquals("Learn Java programming", course.getDescription()));
//
//    }
//}
