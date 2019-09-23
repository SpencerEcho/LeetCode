import java.util.ArrayList;
import java.util.List;
/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * Input: 5
 * Output:
 * [
            [1],
           [1,1],
          [1,2,1],
         [1,3,3,1],
        [1,4,6,4,1]
    ]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int numRows = 5;
        solution.printTriangle(solution.generate(numRows));
    }

    private void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> list : triangle) {
            System.out.println(list);
        }
    }

    /**
     * 杨辉三角（这里注意不要被例子中的结果样式误导，杨辉三角摆正位置后就是一个直角三角形）
     * 一共有numRows行，每行有n个元素，其中第一个和最后一个元素为1，其余为上一行前一列的元素与当前列元素的和
     * 例如 numRows=5，结果如下
     * [1]
     * [1, 1]
     * [1, 2, 1]
     * [1, 3, 3, 1]
     * [1, 4, 6, 4, 1]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        //第0行的列表中第0个位置添加元素1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        //从第1行开始，每行第一个元素和最后一个元素为1，其他元素为上一行前一列的元素与当前列元素的和
        for (int rowNum=1; rowNum<numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(rowNum - 1);
            //第一个元素为1
            row.add(1);
            for (int col=1; col<rowNum; col++) {
                //上一行前一列的元素与当前列元素的和
                row.add(preRow.get(col-1) + preRow.get(col));
            }
            //最后一个元素为1
            row.add(1);
            //添加行
            triangle.add(row);
        }
        return triangle;
    }
}