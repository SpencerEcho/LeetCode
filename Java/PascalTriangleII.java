import java.util.ArrayList;
import java.util.List;
/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * 
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        PascalTriangleII solution = new PascalTriangleII();
        int rowIndex = 5;
        System.out.println(solution.generate_1(rowIndex));
        System.out.println(solution.generate_2(rowIndex));

        
    }

    /**
     * 计算出杨辉三角的所有行后，取其中需要的行作为结果
     * 需要1+2+3+...+n个空间
     */
    public List<Integer> generate_1(int rowIndex) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        tri.add(new ArrayList<>());
        tri.get(0).add(1);
        for (int row=1; row<=rowIndex; row++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            List<Integer> preRow = tri.get(row-1);
            rowList.add(1);
            for (int col=1; col<row; col++) {
                rowList.add(preRow.get(col-1) + preRow.get(col));
            }
            rowList.add(1);
            tri.add(rowList);
        }
        return tri.get(rowIndex);
    }

    /**
     * 依然保留杨辉三角的计算过程，用一个列表保存中间过程的计算结果。这样只需要rowIndex个空间就可以
     * 
     * @param rowIndex
     * @return
     */
    public List<Integer> generate_2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        //第一个元素肯定是1
        list.add(1);
        for (int row=1; row<=rowIndex; row++) {
            int col=row-1;
            //最后一个元素肯定是1
            list.add(col, 1);
            //这里用逆序，不用正序的原因是:
            //正序过程中，当前循环的set(col,val)会覆盖col位置的元素，下一次到list.get(col-1)位置取到的值不是原先的值
            for (; col>0; col--) {
                list.set(col, list.get(col-1) + list.get(col));
            }
        } 
        return list;       
    }
}