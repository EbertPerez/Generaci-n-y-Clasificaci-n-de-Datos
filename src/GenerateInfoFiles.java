import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Genera archivos de prueba pseudoaleatorios para el proyecto
 * "Generación y clasificación de datos".
 *
 * @author EBERT LARRY PEREZ ARDILA / JOHN ALDEMAR MORERA BARRERA
 * @version 1.0
 */
public class GenerateInfoFiles {

    private static final String DATA_FOLDER = "data";
    private static final String SALESMAN_INFO_FILE = "salesmanInfo.txt";
    private static final String PRODUCTS_FILE = "products.txt";

    private static final Random RANDOM = new Random();

    private static final String[] NAMES = {
        "Juan", "Carlos", "Andres", "Luis", "Miguel",
        "Daniel", "Pedro", "Jorge", "Sofia", "Laura"
    };

    private static final String[] LAST_NAMES = {
        "Perez", "Gomez", "Rodriguez", "Martinez", "Lopez",
        "Hernandez", "Garcia", "Torres", "Ramirez", "Sanchez"
    };

    private static final String[] PRODUCT_NAMES = {
        "Teclado", "Mouse", "Monitor", "Impresora", "Portatil",
        "Memoria USB", "Disco SSD", "Audifonos", "Camara Web", "Parlantes"
    };

    /**
     * Metodo principal. Genera los archivos de entrada de prueba
     * sin solicitar informacion al usuario.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        try {
            createDataFolder();

            int salesmanCount = 5;
            int productsCount = 10;
            int salesPerSalesman = 8;

            createProductsFile(productsCount);
            createSalesManInfoFile(salesmanCount);

            for (int i = 1; i <= salesmanCount; i++) {
                String name = NAMES[(i - 1) % NAMES.length];
                String lastName = LAST_NAMES[(i - 1) % LAST_NAMES.length];
                String fullName = name + "_" + lastName;
                long id = 10000000L + i;

                createSalesMenFile(
                    salesPerSalesman,
                    fullName,
                    id
                );
            }

            System.out.println(
                "Proceso finalizado exitosamente. "
                + "Los archivos fueron generados en la carpeta 'data'."
            );
        } catch (IOException exception) {
            System.err.println(
                "Error durante la generacion de los archivos: "
                + exception.getMessage()
            );
        }
    }

    /**
     * Crea la carpeta donde se almacenan los archivos generados.
     *
     * @throws IOException si no es posible crear la carpeta
     */
    private static void createDataFolder() throws IOException {
        File folder = new File(DATA_FOLDER);

        if (!folder.exists() && !folder.mkdirs()) {
            throw new IOException(
                "No fue posible crear la carpeta de datos."
            );
        }
    }

    /**
     * Crea un archivo de ventas para un vendedor determinado.
     * Cada linea contiene el ID de producto y la cantidad vendida.
     *
     * @param randomSalesCount cantidad de ventas a generar
     * @param name nombre identificador del vendedor
     * @param id documento del vendedor
     * @throws IOException si ocurre un error de escritura
     */
    public static void createSalesMenFile(
        int randomSalesCount,
        String name,
        long id
    ) throws IOException {

        String fileName = DATA_FOLDER
            + File.separator
            + "sales_" + id + "_" + name + ".txt";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {

            writer.write("CC;" + id);
            writer.newLine();

            for (int i = 0; i < randomSalesCount; i++) {
                int productId = 1 + RANDOM.nextInt(10);
                int quantity = 1 + RANDOM.nextInt(10);

                writer.write(productId + ";" + quantity);
                writer.newLine();
            }
        }
    }

    /**
     * Crea el archivo con la informacion de los productos.
     * Cada producto contiene ID, nombre y precio unitario.
     *
     * @param productsCount cantidad de productos a generar
     * @throws IOException si ocurre un error de escritura
     */
    public static void createProductsFile(int productsCount)
        throws IOException {

        String fileName = DATA_FOLDER
            + File.separator
            + PRODUCTS_FILE;

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {

            for (int i = 1; i <= productsCount; i++) {
                String productName =
                    PRODUCT_NAMES[(i - 1) % PRODUCT_NAMES.length]
                    + "_" + i;

                double price = 10000 + RANDOM.nextInt(190001);

                writer.write(
                    i + ";" + productName + ";" + price
                );
                writer.newLine();
            }
        }
    }

    /**
     * Crea el archivo con la informacion de los vendedores.
     * Cada vendedor ocupa una linea.
     *
     * @param salesmanCount cantidad de vendedores
     * @throws IOException si ocurre un error de escritura
     */
    public static void createSalesManInfoFile(int salesmanCount)
        throws IOException {

        String fileName = DATA_FOLDER
            + File.separator
            + SALESMAN_INFO_FILE;

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))) {

            for (int i = 1; i <= salesmanCount; i++) {
                String name = NAMES[(i - 1) % NAMES.length];
                String lastName = LAST_NAMES[(i - 1) % LAST_NAMES.length];
                long id = 10000000L + i;

                writer.write(
                    "CC;" + id + ";" + name + ";" + lastName
                );
                writer.newLine();
            }
        }
    }
}
