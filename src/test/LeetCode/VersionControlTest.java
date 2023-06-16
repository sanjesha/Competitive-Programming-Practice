package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionControlTest {
    @Test
    void testVersion(){
        VersionControl vc = new VersionControl();
        int val = vc.firstBadVersion(2129753390);
        System.out.println(val);
    }

}