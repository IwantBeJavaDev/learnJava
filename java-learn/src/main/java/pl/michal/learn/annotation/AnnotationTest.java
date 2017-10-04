package pl.michal.learn.annotation;



import pl.michal.learn.annotation.TesterInfo.Priority;

@TesterInfo(priority = Priority.HIGHT, tags = {"sale","order"}, createDate = "04.10.2017")
public class AnnotationTest {

	@Test
	public void testA() {
		if (true) {
			throw new RuntimeException("This test always failed");
		}
	}
	
	@Test(enabled = false)
	public void testB() {
		if (false) {
			throw new RuntimeException("This test always passed");
		}
	}
	
	@Test(enabled = true)
	void testC() {
	  if (10 > 1) {
		// do nothing, this test always passed.
	  }
	}
}
