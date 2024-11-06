/*
 * Copyright 2024 preed.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reedmanit.restaurantbill.model;

import com.google.common.hash.Hashing;
import com.reedmanit.restaurantbill.MainView;
import com.vaadin.flow.server.VaadinServlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author preed
 */
public class Security {

    public String passCode;
    public Boolean validPassCode = false;

    private Security() {
    }

    public static Security getInstance() {

        return SecurityHolder.INSTANCE;
    }

    private static class SecurityHolder {

        private static final Security INSTANCE = new Security();

    }

    public void retrievePassCode() {

        InputStream propStream = VaadinServlet.getCurrent().getServletContext().getResourceAsStream("/WEB-INF/classes/app.properties");

        Properties props = new Properties();
        try {
            props.load(propStream);
            passCode = (String) props.get("passcode");
          //  System.out.println(passCode);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public void validatePasscode(String codeProvided) {

     //   System.out.println("Passcode is " + passCode + " " + "code provided " + codeProvided);

        String sha256hex = Hashing.sha256()
                .hashString(codeProvided, StandardCharsets.UTF_8)
                .toString();
        
       // System.out.println(codeProvided + " " + sha256hex);

        if (sha256hex.equals(passCode)) {
            validPassCode = true;
        } else {
            validPassCode = false;
        }
    }
}
