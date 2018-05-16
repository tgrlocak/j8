/**
 * You can import and use Java classes and packages using the <i>JavaImporter</i>.
 * 
 */
function importingExample(e) {
	var imports = new JavaImporter(java.util, java.io, java.nio.file);
	
	//The below demonstrates that paths is an instance of LinkedList and prints out the list.
	with(imports) {
		var paths = new LinkedList();
		print(paths instanceOf LinkedList);
		
		paths.add(Paths.get("file1"));
		paths.add(Paths.get("file2"));
		paths.add(Paths.get("file3"));
		
		print(paths);
	}
	
	// The below code write text into the files
	for(var i=0; i < paths.size(); i++) {
		Files.newOutputStream(paths.get(i)).write("test\n".getBytes());
	}
}