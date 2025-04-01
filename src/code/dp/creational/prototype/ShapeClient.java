package code.dp.creational.prototype;

public class ShapeClient {

    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using prototype.
    public Shape createShape(){
        return this.shapePrototype.clone();
    }
}
