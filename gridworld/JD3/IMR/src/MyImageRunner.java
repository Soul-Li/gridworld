import imagereader.Runner;
final class MyImageRunner {
	private MyImageRunner() {}
	
	public static void main(String[] args) {
		MyImageIO mii = new MyImageIO();
		MyImageProcessor mip = new MyImageProcessor();
		Runner.run(mii, mip);
	}
}
