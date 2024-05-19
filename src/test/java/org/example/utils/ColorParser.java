package org.example.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorParser {
    public static Map<String, String> parseColor(String color) {
        Map<String, String> colorComponents = new HashMap<>();
        Pattern rgbaPattern = Pattern.compile("rgba?\\((\\d+),\\s*(\\d+),\\s*(\\d+),?\\s*(\\d*\\.?\\d+)?\\)");
        Matcher rgbaMatcher = rgbaPattern.matcher(color);

        if (rgbaMatcher.matches()) {
            colorComponents.put("red", rgbaMatcher.group(1));
            colorComponents.put("green", rgbaMatcher.group(2));
            colorComponents.put("blue", rgbaMatcher.group(3));
            colorComponents.put("alpha", rgbaMatcher.group(4) != null ? rgbaMatcher.group(4) : "1");
        }

        return colorComponents;
    }
}
