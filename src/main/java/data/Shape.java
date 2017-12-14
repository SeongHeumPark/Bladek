package data;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seongheum.park
 */
public enum Shape {
    NO_SHAPE("", "NO-SHAPE"),
    HEXAGON("H", "HEXAGON"),
    OCTAGON("O", "OCTAGON"),
    TRIANGLE("T", "TRIANGLE"),
    RECTANGLE("R", "RECTANGLE"),
    PENTAGON("P", "PENTAGON"),
    DIAMOND("<>", "DIAMOND"),
    STAR("S", "STAR"),
    BALL("", "BALL");

    private static Map<String, Shape> shapes = new HashMap<>();

    static {
        for (Shape shape : values()) {
            shapes.put(shape.key, shape);
        }
    }

    private final String key;
    private final String name;

    Shape(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public static String getString(String color, Shape shape) {
        StringBuilder builder = new StringBuilder(color);
        if (StringUtils.isNotEmpty(shape.key)) {
            builder
                .append("-")
                .append(shape.key);
        }

        return builder.toString();
    }

    public static String getSuffix(Shape shape) {
        if (shape == null) {
            return "-" + NO_SHAPE.key;
        } else if (StringUtils.isEmpty(shape.key) || shape == DIAMOND) {
            return shape.key;
        } else {
            return "-" + shape.key;
        }
    }

    public static String getColor(String colorShape) {
        if (StringUtils.isEmpty(colorShape)) {
            return "";
        } else {
            return colorShape.split("-")[0];
        }
    }

    public static Shape fromString(String shape) {
        if (StringUtils.isEmpty(shape)) {
            return NO_SHAPE;
        } else {
            String key = "";
            if (shape.contains("-")) {
                key = shape.split("-")[1];
            }

            return shapes.get(key);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
