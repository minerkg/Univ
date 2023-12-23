import java.util.Arrays;

public class Main {
    public static void printImage(Image img) {
        System.out.println(Arrays.deepToString(
                        img.getImage()).replace("], ", "]\n").
                        replace("[[", "[").
                        replace("]]", "]").
                        concat("\n"));
    }
    public static void zoom(Image img) {
        int dim = img.getDim();
        int newDim = dim * 2;
        Image newImage = new Image(newDim);

        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                int oldPix = img.getPixel(i, j);
                int k = i * 2;
                int l = j * 2;
                newImage.changePixel(new int[]{k, l}, oldPix);
                newImage.changePixel(new int[]{k+1, l+1}, oldPix);
                newImage.changePixel(new int[]{k+1, l}, oldPix);
                newImage.changePixel(new int[]{k, l+1}, oldPix);
            }
        }
        img.setImage(newImage.getImage());
    }

    public static void rotire(Image img) {
        int dim = img.getDim();
        int[][] temp = new int[dim][dim];
        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                temp[j][dim-1-i] = img.getPixel(i, j);
            }
        }
        img.setImage(temp);
    }
    public static void inversare(Image img) {
        int dim = img.getDim();
        for (int i=0; i<dim; i++) {
            for (int j=0; j<dim; j++) {
                int oldPix = img.getPixel(i, j);
                img.changePixel(new int[]{i, j}, ((oldPix == 1) ? 0 : 1));
            }
        }
    }

    public static void doModifications(char[] transformari, Image img) {
        for (char transf : transformari) {
            switch (transf) {
                case 'I':
                    inversare(img);
                    break;
                case 'R':
                    rotire(img);
                    break;
                case 'Z':
                    zoom(img);
                    break;
            }
        }
        printImage(img);
    }

    public static void main(String[] args) {
        Image image = new Image(5);

        printImage(image);


        image.changePixel(new int[]{2, 0}, 1);
        image.changePixel(new int[]{2, 1}, 1);
        image.changePixel(new int[]{2, 2}, 1);
        image.changePixel(new int[]{2, 3}, 1);

        doModifications(new char[]{'I', 'R', 'R', 'Z'}, image);

    }
}