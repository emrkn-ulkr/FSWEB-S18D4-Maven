package com.workintech.s18d1.util;

import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkId(Integer id) {
        if (id == null || id < 0) {
            throw new BurgerException("ID değeri 0'dan küçük veya boş olamaz: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}