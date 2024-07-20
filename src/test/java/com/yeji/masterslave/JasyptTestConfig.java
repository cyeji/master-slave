package com.yeji.masterslave;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JasyptTestConfig {

    @Autowired
    private StringEncryptor jasyptEncryptor;

    @Test
    void custom_jasypt_test() {
        String encrypted = jasyptEncryptor.encrypt("test");
        System.out.println("encrypted: " + encrypted);

        String decrypted = jasyptEncryptor.decrypt(encrypted);
        System.out.println("decrypted: " + decrypted);

        assertEquals(encrypted, decrypted);
    }

}
