package com.webperside.courseerpbackend;

import com.webperside.courseerpbackend.models.mappers.CourseEntityMapper;
import com.webperside.courseerpbackend.models.mybatis.course.Course;
import com.webperside.courseerpbackend.models.properties.security.SecurityProperties;
import com.webperside.courseerpbackend.payload.auth.SignUpPayload;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import com.webperside.courseerpbackend.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseErpBackendApplication implements CommandLineRunner {
//    @Autowired
//    private UserRepository userRepository;




    public static void main(String[] args) {
        SpringApplication.run(CourseErpBackendApplication.class, args);
    }

    private final SecurityProperties securityProperties;
    private final AccessTokenManager accessTokenManager;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;



    @Override
    public void run(String... args) throws Exception {
        SignUpPayload payload =new SignUpPayload();
        payload.setName("fdfdf");
        payload.setCourseName("abc");

        Course  course = CourseEntityMapper.INSTANCE.fromSignUpPayload(payload);
        System.out.println(course);

      //  System.out.println(securityProperties.getJwt().getRefreshTokenValidityTime(true));
//        System.out.println("------------------------------------------------------");
//        System.out.println(securityProperties.getJwt().getRefreshTokenValidityTime());
////        User user = User.builder()
//                .status(UserStatus.ACTIVE)
//                .email("test@gmail.com")
//                .name("Test")
//                .surname("Testov")
//                .password(passwordEncoder.encode("12345"))
//                .phoneNumber("5431756")
//                .roleId(1L)
//                .build();
//        userService.insert(user);



//        User user  = User.builder().email("email@email.com").build();
//        user.setId(1L);
//        String token = accessTokenManager.generate(user);
//        System.out.println(token);
//        System.out.println( accessTokenManager.read(token));

//        System.out.println(securityProperties);
//        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
//        keyGenerator.initialize(2048);
//        KeyPair kp = keyGenerator.genKeyPair();
//        PublicKey publicKey = kp.getPublic();
//        PrivateKey privateKey = kp.getPrivate();
//
//        String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
//        String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
//
//        System.out.println(convertToPublicKey(encodedPublicKey));
//
//        System.out.println();
//
//        System.out.println(convertToPrivateKey(encodedPrivateKey));
    }

    private static String convertToPrivateKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PRIVATE KEY-----\n");
        result.append(key);
        result.append("\n-----END PRIVATE KEY-----");
        return result.toString();
    }

    private static String convertToPublicKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN PUBLIC KEY-----\n");
        result.append(key);
        result.append("\n-----END PUBLIC KEY-----");
        return result.toString();
    }


}
