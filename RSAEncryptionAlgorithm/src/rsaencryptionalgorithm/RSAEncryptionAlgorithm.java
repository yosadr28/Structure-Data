/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsaencryptionalgorithm;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
import java.util.*;

/**
 *
 * @author Yosef Adrian
 */
public class RSAEncryptionAlgorithm {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int p, q, n, z, d = 0, e, i;
        String a = scn.next();
        double c
        BigInteger aback;
        p = 3;
        q = 11;

        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("nilai z : " + z);

        for (e = 2; e < z; e++) {

            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }

    }

}
