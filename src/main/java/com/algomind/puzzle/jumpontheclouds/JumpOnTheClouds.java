package com.algomind.puzzle.jumpontheclouds;

public class JumpOnTheClouds {
    int jumpingOnTheClouds(int[] c, int k) {
        int current = 0;
        int life = 100;

        do {
            current = (current + k) % c.length;
            life--;
            if(c[current] == 1) life -= 2;
        }while(current != 0 || life <= 0);

        return life;
    }
}
