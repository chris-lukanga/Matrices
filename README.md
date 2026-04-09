Based on your repository content and your journey as a second-year Computer Science and Informatics student at the University of Johannesburg (UJ), here is a tailored `README.md` for your project. It highlights the educational purpose of the project and documents the current functionality.

***

# Linear Algebra Matrix Implementation

This repository is a personal project developed to reinforce concepts learned in **Linear Algebra** as part of my second-year **Computer Science and Informatics** curriculum at the **University of Johannesburg (UJ)**. I believe that recreating mathematical concepts in code is the best way to master them.

## 🚀 Project Overview
The project currently consists of a Java-based matrix library that supports fundamental matrix operations. It is designed to be a growing library where new features are added as I progress through my coursework.

## 🛠 Features
The `Matrix` class currently supports the following operations:
* **Matrix Construction**: Create matrices by specifying rows, columns, and data in row-major order.
* **Identity Matrices**: Generate $n \times n$ identity matrices automatically.
* **Basic Arithmetic**: 
    * **Addition & Subtraction**: Defined for matrices of the same dimensions.
    * **Scalar Multiplication**: Multiply an entire matrix by a single value.
* **Matrix Multiplication**: Standard dot-product multiplication, including checks to ensure column-row dimension compatibility.
* **Vector Extraction**: Methods to retrieve specific row or column vectors from a matrix.
* **Utility Methods**: Easy access to specific values using `getValueAt(row, col)` and a formatted `toString()` method for clean console output.


## 💻 Usage Example
You can see how to use the library in the `Main.java` file. Here is a quick snippet:

```java
// Create a 2x1 Matrix
Matrix A = new Matrix(2, 1, new float[]{1, 2});

// Create a 1x3 Matrix
Matrix B = new Matrix(1, 3, new float[]{2, 0, 4});

// Multiply them to get a 2x3 Matrix
Matrix result = A.mult(B);
System.out.println(result);
```


## 📂 File Structure
* `Matrix.java`: The core logic containing the matrix properties and mathematical operations.
* `Main.java`: A driver class used for testing and demonstrating implemented features.

## 🎓 Academic Context
As a UJ student, I am building this to bridge the gap between theoretical Informatics and practical software development. Future updates will likely include:
* Determinant calculation.
* Matrix Inversion.
* Solving systems of linear equations (Gaussian Elimination).

---
*Developed by a UJ Computer Science Student.*