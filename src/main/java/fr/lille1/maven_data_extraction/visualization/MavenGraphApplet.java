package fr.lille1.maven_data_extraction.visualization;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JApplet;

import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import fr.lille1.maven_data_extraction.core.Project;
import fr.lille1.maven_data_extraction.core.graph.MavenLabeledEdge;
import fr.lille1.maven_data_extraction.core.graph.MavenMultigraph;

/**
 * 
 * @author Alexandre Bonhomme
 * 
 */
public class MavenGraphApplet extends JApplet {

	private static final long serialVersionUID = -5809860607499098885L;

	private final MavenMultigraph<MavenLabeledEdge> graph;
	private JGraphXAdapter<Project, MavenLabeledEdge> adapter;

	/**
	 * @param graph
	 */
	public MavenGraphApplet(MavenMultigraph<MavenLabeledEdge> graph) {
		this.graph = graph;
	}

	@Override
	public void init() {
		// create a visualization using JGraph, via an adapter
		adapter = new JGraphXAdapter<Project, MavenLabeledEdge>(
				graph.getListenableGraph());

		final mxGraphComponent graphComponent = new mxGraphComponent(adapter);
		getContentPane().add(graphComponent);

		graphComponent.getGraphControl().addMouseWheelListener(
				new MouseWheelListener() {
			
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						if (e.getWheelRotation() > 0) {
							graphComponent.zoomOut();
						} else {
							graphComponent.zoomIn();
						}
					}
		});

		// positioning via jgraphx layouts
		mxCircleLayout layout = new mxCircleLayout(adapter);
		layout.execute(adapter.getDefaultParent());
	}

}
