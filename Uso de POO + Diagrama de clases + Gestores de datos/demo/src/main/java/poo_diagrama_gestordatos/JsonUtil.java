package poo_diagrama_gestordatos;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> List<T> cargarLista(String ruta, Type tipo) {
        try (Reader reader = new FileReader(ruta)) {
            return gson.fromJson(reader, tipo);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> void guardarLista(String ruta, List<T> lista) {
        try (Writer writer = new FileWriter(ruta)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
