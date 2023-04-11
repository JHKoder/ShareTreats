package io;

import client.ClientInputType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class Input {
    private final BufferedReader br;

    public Input() {
        br = new BufferedReader(new InputStreamReader((System.in)));
    }

    public String[] put() {
        try {
            String[] input =  br.readLine().split(" ");
            validClientInput(input);
            return input;
        } catch (IllegalArgumentException | IOException ignored) {
        }
        out.println("[입력 형식이 올바르지 않습니다.]");
        return new String[]{"HELP"};
    }

    private void validClientInput(String[] input) {
        if( ClientInputType.find(input[0]) == null){
            throw new IllegalArgumentException();
        }
    }

    public void close() {
        try {
            br.close();
        } catch (IOException ignored) {
        }
    }

    public String[] toArr(String[] arr) {
        String[] arrs = new String[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            arrs[i-1] = arr[i];
        }
        return arrs;
    }
}
