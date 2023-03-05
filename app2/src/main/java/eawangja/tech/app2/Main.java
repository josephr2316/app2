package eawangja.tech.app2;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {

        var app = Javalin.create(javalinConfig -> {
                    javalinConfig.staticFiles.add(staticFileConfig -> {
                        staticFileConfig.hostedPath = "/";
                        staticFileConfig.directory = "/public";
                        staticFileConfig.location = Location.CLASSPATH;
                    });
                })
                .start(7090);

        app.get("/", ctx -> {
            ctx.redirect("index.html");
        });
    }
}