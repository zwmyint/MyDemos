package wait.play.model;

public class MyFile {
	private String fileName;
	private String createDate;
	private String path;
	private String fileSuffix;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileSuffix() {
		int pos = fileName.lastIndexOf(".");
		if (pos > 0) {
			fileSuffix = fileName.substring(pos + 1);
		}
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	
	
	
	
	

}
