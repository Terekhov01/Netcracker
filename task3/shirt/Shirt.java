package task3.shirt;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }


    public static Shirt getShirt(String shirt){
        String[] fields = shirt.split(",");
        String id = fields[0];
        String description = fields[1];
        String color = fields[2];
        String size = fields[3];
        return new Shirt(id,description,color,size);
    }

    public static Shirt[] getShirts(String[] shirts){
        int amount = shirts.length;
        Shirt[] shs = new Shirt[amount];
        for(int i=0;i<amount;i++){
            shs[i] = getShirt(shirts[i]);
        }
        return shs;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
