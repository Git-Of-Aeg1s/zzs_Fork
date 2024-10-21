package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class L2022211887_8_Test {

    // 测试用例设计的总体原则：
    // 1. 等价类划分：根据输入的不同特性，将其划分为若干等价类，从每个等价类中选取一个或多个代表性数据作为测试用例。
    //    - 例如，对于输入网格，我们可以将空网格、全为水的网格、包含一个或多个岛屿的网格划分为不同的等价类。
    // 2. 边界值分析：选取输入变量的边界值进行测试，以发现可能的边界错误。
    //    - 例如，对于网格的行数和列数，我们可以测试 0x0、1x1、2x2 等小尺寸网格，以及大尺寸网格。
    // 3. 因果图法：如果输入条件之间存在复杂的逻辑关系，可以使用因果图法来设计测试用例。
    //    - 在本例中，输入条件相对简单，因此不采用因果图法。

    @Test
    public void testNumIslands_EmptyGrid() {
        // 测试目的：验证空网格的岛屿数量为0。
        char[][] grid = {};
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);

        assertEquals(0, result);
    }

    @Test
    public void testNumIslands_SingleWaterGrid() {
        // 测试目的：验证全为水的网格（即没有岛屿）的岛屿数量为0。
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result);
    }



    @Test
    public void testNumIslands_GridWithSingleCell() {
        // 测试目的：验证只有一个单元格且为陆地的网格的岛屿数量为1。
        char[][] grid = {
                {'1'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(1, result);
    }

    @Test
    public void testNumIslands_GridWithSingleCellWater() {
        // 测试目的：验证只有一个单元格且为水的网格的岛屿数量为0。
        char[][] grid = {
                {'0'}
        };
        Solution8 solution = new Solution8();
        int result = solution.numIslands(grid);
        assertEquals(0, result);
    }

    // 可以根据需要添加更多测试用例，例如：
    // - 网格的行数或列数为0的情况（已在testNumIslands_EmptyGrid中隐式测试）
    // - 网格中包含不规则形状的岛屿
    // - 网格中包含非常大的岛屿或非常多的岛屿
}