package fr.lille1.maven_data_extraction.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a version for a {@link Project} object.
 * 
 * @author Alexandre Bonhomme
 * 
 */
public class Version {

	private final String versionNumber;
	private final File pomFile;
	private final List<Project> listDependents; 

	/**
	 * @param version
	 * @param pom
	 */
	public Version(String version, File pom) {
		this.versionNumber = version;
		this.pomFile = pom;
		this.listDependents = new ArrayList<Project>();
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public File getPomFile() {
		return pomFile;
	}

	@Override
	public boolean equals(Object obj) {
		Version version = (Version) obj;

		if (version == null) {
			return false;
		}

		if (!version.getVersionNumber().equals(versionNumber)) {
			return false;
		}

		if (!version.getPomFile().equals(pomFile)) {
			return false;
		}

		return true;
	}

	public List<Project> getDependents() {
		return listDependents;
	}
	
	

}
