import java.util.*;

/**
 * L2023112279_14_Text
 * 测试目标：Solution14 - 复原IP地址
 * 
 * 测试用例设计总体原则：
 * ============================================================
 * 1. 等价类划分原则：
 *    - 有效IP段划分：
 *      有效等价类：每个整数在0-255之间，且不能有前导0
 *      无效等价类：整数>255，或存在前导0（如01, 001等）
 * 
 *    - 字符串长度划分：
 *      有效等价类：长度在4-12之间（每个段最少1位，最多3位）
 *      无效等价类：长度<4 或 >12
 * 
 *    - 输入字符串划分：
 *      有效等价类：仅包含数字字符
 *      无效等价类：包含非数字字符
 * 
 * 2. 边界值分析：
 *    - 最小值：长度为4的字符串（如"0000"）
 *    - 最大值：长度为12的字符串（如"255255255255"）
 *    - 单段边界：0, 255
 * 
 * 3. 特殊值测试：
 *    - 全0字符串
 *    - 包含前导0的情况
 *    - 多种可能的IP组合
 * 
 * 4. 功能覆盖原则：
 *    - 正常功能测试：多个有效IP组合
 *    - 边界条件测试：最小/最大长度
 *    - 异常输入测试：长度不符合要求
 * ============================================================
 */
public class L2023112279_14_Text {
    
    private Solution solution;
    
    /**
     * 测试方法：testExample1
     * 测试目的：验证题目示例1的正确性，输入"25525511135"应返回两个有效IP地址
     * 测试用例：等价类-标准有效输入，包含多个可能的分割点
     * 预期结果：["255.255.11.135", "255.255.111.35"]
     */
    public void testExample1() {
        solution = new Solution();
        String input = "25525511135";
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例1：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testExample2
     * 测试目的：验证全0输入的特殊情况
     * 测试用例：边界值-全0输入，单个IP组合
     * 预期结果：["0.0.0.0"]
     */
    public void testExample2() {
        solution = new Solution();
        String input = "0000";
        List<String> expected = Arrays.asList("0.0.0.0");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例2：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testExample3
     * 测试目的：验证包含0和多个分割点的情况
     * 测试用例：等价类-包含0的有效段，多个IP组合
     * 预期结果：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */
    public void testExample3() {
        solution = new Solution();
        String input = "101023";
        List<String> expected = Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", 
                                              "10.10.2.3", "101.0.2.3");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例3：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testSingleDigitIP
     * 测试目的：验证每段都是单位数的情况
     * 测试用例：边界值-最小分割组合
     * 预期结果：["1.1.1.1"]
     */
    public void testSingleDigitIP() {
        solution = new Solution();
        String input = "1111";
        List<String> expected = Arrays.asList("1.1.1.1");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例4：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testMaxValueIP
     * 测试目的：验证最大合法IP值的情况
     * 测试用例：边界值-每段都取最大值255
     * 预期结果：["255.255.255.255"]
     */
    public void testMaxValueIP() {
        solution = new Solution();
        String input = "255255255255";
        List<String> expected = Arrays.asList("255.255.255.255");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例5：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testWithZeros
     * 测试目的：验证包含多处0的情况
     * 测试用例：等价类-多个0的有效组合
     * 预期结果：["0.0.0.0"]
     */
    public void testWithZeros() {
        solution = new Solution();
        String input = "0000";
        List<String> expected = Arrays.asList("0.0.0.0");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例6：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testShortInput
     * 测试目的：验证输入长度不足的情况
     * 测试用例：边界值-长度小于4
     * 预期结果：空列表[]
     */
    public void testShortInput() {
        solution = new Solution();
        String input = "123";
        List<String> expected = Arrays.asList();
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例7：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 测试方法：testComplexCase
     * 测试目的：验证复杂分割情况，包含多个有效组合
     * 测试用例：等价类-复杂标准输入
     * 预期结果：多个有效IP组合
     */
    public void testComplexCase() {
        solution = new Solution();
        String input = "19216801";
        List<String> expected = Arrays.asList("19.216.80.1", "192.16.80.1", "192.168.0.1");
        List<String> actual = solution.restoreIpAddresses(input);
        
        System.out.println("\n测试用例8：");
        System.out.println("输入: \"" + input + "\"");
        System.out.println("预期: " + expected);
        System.out.println("实际: " + actual);
        
        assertEqualLists(expected, actual);
        System.out.println("通过");
    }
    
    /**
     * 辅助方法：断言两个列表相等（忽略顺序）
     */
    private void assertEqualLists(List<String> expected, List<String> actual) {
        if (expected.size() != actual.size()) {
            System.err.println("✗ 失败：数量不匹配");
            throw new AssertionError("Expected size " + expected.size() + 
                                   ", but got " + actual.size());
        }
        
        for (String item : expected) {
            if (!actual.contains(item)) {
                System.err.println("✗ 失败：缺少元素: " + item);
                throw new AssertionError("Expected item not found: " + item);
            }
        }
    }
    
    /**
     * 主方法：运行所有测试
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("L2023112279_14_Text - Solution14 复原IP地址单元测试");
        System.out.println("=".repeat(70));
        
        L2023112279_14_Text tester = new L2023112279_14_Text();
        int passed = 0;
        int failed = 0;
        
        try {
            tester.testExample1();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例1失败: " + e.getMessage());
        }
        
        try {
            tester.testExample2();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例2失败: " + e.getMessage());
        }
        
        try {
            tester.testExample3();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例3失败: " + e.getMessage());
        }
        
        try {
            tester.testSingleDigitIP();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例4失败: " + e.getMessage());
        }
        
        try {
            tester.testMaxValueIP();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例5失败: " + e.getMessage());
        }
        
        try {
            tester.testWithZeros();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例6失败: " + e.getMessage());
        }
        
        try {
            tester.testShortInput();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例7失败: " + e.getMessage());
        }
        
        try {
            tester.testComplexCase();
            passed++;
        } catch (AssertionError e) {
            failed++;
            System.err.println("测试用例8失败: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("测试总结：通过 " + passed + "，失败 " + failed + "，总计 " + (passed + failed));
        System.out.println("=".repeat(70));
        
        if (failed > 0) {
            System.exit(1);
        }
    }
}

