package com.rozy.dailytracker.management;

import com.rozy.dailytracker.main;
import java.nio.file.Path;

public class writeHandler {
        static Path path = Path.of("src/com/rozy/dailytracker/management");
        private  String user = "/" + main.userLogged;
        public String filePath = path.toString() + user + ".txt";
        
        public static Path loginFile = Path.of("src/com/rozy/dailytracker/management/login");
}
