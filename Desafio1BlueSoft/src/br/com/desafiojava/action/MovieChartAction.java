package br.com.desafiojava.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.jfree.chart.JFreeChart;

import br.com.desafiojava.chart.ChartMovie;
import br.com.desafiojava.repository.MovieRepository;

@ParentPackage("jfreechart-default") 
@Namespace(value="/MovieChart")
public class MovieChartAction extends ActionDefault {

	private JFreeChart chart;
	private MovieRepository movieRepository = new MovieRepository(this.getEntityManager());
	public MovieChartAction() {
		
	}
		
	@Action(  
			value="createChartMovie", 
			results = @Result(name="success",params= { "Width","1024" , "height","500" }, type="chart" )	
	)
	public String createChartMovie(){ 
		ChartMovie.createChart(this.movieRepository.listMovie());		
		this.chart = ChartMovie.getChart();		
		return "success";		
	}
	
	public final JFreeChart getChart() {
		return chart;
	}

	public final void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}
