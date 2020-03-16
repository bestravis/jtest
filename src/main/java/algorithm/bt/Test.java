package algorithm.bt;

import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {
        BinaryTree bt = BinaryTree.createBinaryTree();
        bt.addNode(1);
        System.out.println(JSONObject.toJSONString(bt));
    }

}


