public class Image {
    private int dim;
    private int[][] image;

    public int getDim() {
        return this.dim;
    }

    public int getPixel(int x, int y) {
        return this.image[x][y];
    }

    public int[][] getImage() {
        return this.image;
    }

    public void setDim(int dimension) {
        this.dim = dimension;
    }
    public void setImage(int[][] image) {
        this.image = image;
    }
    private void fillUpWithZeros() {
        image =  new int[this.dim][this.dim];
        for (int i=0; i<this.dim; i++) {
            for (int j=0; j<this.dim; j++) {
                this.image[i][j] = 0;
            }
        }
    }
    public void changePixel(int[] pixelPosition, int pixelValue) {
        this.image[pixelPosition[0]][pixelPosition[1]] = pixelValue;
    }

    public Image(int dimension) {
        this.dim = dimension;
        fillUpWithZeros();
    }

}


