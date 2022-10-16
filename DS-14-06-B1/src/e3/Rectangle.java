package e3;

// Represents a rectangle
public class Rectangle {

	private int base;
	private int height;
        
        // Initializes a new rectangle with the values passed by parameter .
        // Throws IllegalArgumentException if a a negative value is passed to any of
        // the dimensions .
	public Rectangle(int base, int height) {
		if (base < 0) {
			throw new IllegalArgumentException("Illegal value!");
		} else {
			this.base = base;
		}
		if (height < 0) {
			throw new IllegalArgumentException("Illegal value!");
		} else {
			this.height = height;
		}
	}

        // Copy constructor
	public Rectangle(Rectangle r) {
		this.base = r.base;
		this.height = r.height;
	}
        
        // Getters
	public int getBase() {
		return base;
	}
	public int getHeight() {
		return height;
	}

        // Setters . Throw IllegalArgumentException if the parameters are negative .
	public void setBase(int base) {
		if (base < 0) {
			throw new IllegalArgumentException("Illegal value!");
		} else {
			this.base = base;
		}
	}
	public void setHeight(int height) {
		if (height < 0) {
			throw new IllegalArgumentException("Illegal value!");
		} else {
			this.height = height;
		}
	}

        // Return true if the rectangle is a square
	public boolean isSquare() {
		boolean square;
		square = (base == height);
		return square;
	}

        // Calculate the area of the rectangle
	public int area() {
		int area;
		area = base * height;
		return area;
	}

        // Calculate the perimeter of the rectangle .
	public int perimeter() {
		int perimeter;
		perimeter = 2 * base + 2 * height;
		return perimeter;
	}

        // Calculate the length of the diagonal
	public double diagonal() {
		double diagonal;
		diagonal = Math.sqrt(base * base + height * height);
		return diagonal;
	}

        // Turn this rectangle 90 degrees ( changing base by height ).
	public void turn() {
		int turn;
		turn = base;
		base = height;
		height = turn;
	}

        // Ensure that this rectangle is oriented horizontally ( the base is greater
        // or equal than the height ).
	public void putHorizontal() {
		if (height > base) {
			turn();
		}
	}

        // Ensure that this rectangle is oriented vertically ( the height is greater
        // or equal than the base ).
	public void putVertical() {
		if (base > height) {
			turn();
		}
	}

        // Two rectangles are equal if the base and the height are the same .
        // It does not take into account if the rectangle is rotated .
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rectangle rectangle1 = new Rectangle(this.base, this.height);
		Rectangle rectangle2 = (Rectangle) obj;
		rectangle1.putHorizontal();
		rectangle2.putHorizontal();
		if (rectangle1.base == rectangle2.base) {
			if (rectangle1.height == rectangle2.height) {
				return true;
			}
		}
		return false;
	}

        // It complies with the hashCode contract and is consistent with the equals .
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + this.height + this.base;
		return hash;
	}

}