package bl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import bl.json.*;
import dl.*;
import eus.ehu.INTEL901_504021.TTA1718.utils.FileUtils;


@Singleton//Anotación de EJB compatible con Web Service
@Path("/School")
public class LogicREST {
		
	

		@Context private javax.servlet.http.HttpServletRequest hsr;
		
		@PersistenceContext
		EntityManager em;
		
		
		@SuppressWarnings("unchecked")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)	
		@Path("/uploadSolution")	
		public Response uploadSolution(SolutionJSON solutionJSON) {
			System.out.println("uploadSolution: "+hsr.getRemoteAddr());
			Response response=null;
			
			Question question=em.find(Question.class, solutionJSON.getQuestion());
			if(question != null) {
			
				Solution solution = new Solution();
				solution.setQuestionBean(question);
				solution.setScore(solutionJSON.getScore());
				solution.setDate(solutionJSON.getDate());
				
				em.persist(solution);
				
				response=Response.status(200).entity("Solution uploaded").build();
			}
			else
				response=Response.status(200).entity("No question available for this solution").build();
			
			
			return response;
		}

		
		
		
	    
		@SuppressWarnings("unchecked")
		@GET
		@Produces(MediaType.APPLICATION_JSON)	
		@Path("/requestQuestions")	
		public Response requestQuestions() {
			System.out.println("requestQuestions: "+hsr.getRemoteAddr());
			Response response=null;
		
			/// El getResultLis hace que si esta vacio no se produzca una excepcion
			List<Question> questionList=(List<Question>)em.createNamedQuery("Question.findAll").getResultList(); //setParameter("appField", appField).getResultList();
			if(questionList.size()>0){//Si la lista de soluciones obtenida en la consulta es de 1 elemento
				List<QuestionJSON> questionJSONList = new ArrayList<QuestionJSON>();
				
				for(int i=0; i<questionList.size(); i++) {
					QuestionJSON questionJSON = new QuestionJSON(questionList.get(i).getIdQuestion(),questionList.get(i).getAnswer(),
							questionList.get(i).getAppField(),questionList.get(i).getOpt1(),questionList.get(i).getOpt2(),
							questionList.get(i).getOpt3(),questionList.get(i).getOpt4(),questionList.get(i).getWeight1(),
							questionList.get(i).getWeight2(),questionList.get(i).getWeight3(),questionList.get(i).getWeight4(),
							questionList.get(i).getWording());
					questionJSONList.add(questionJSON);
				}
				QuestionsJSON questionsJSON = new QuestionsJSON(questionJSONList);
				response=Response.status(200).entity(questionsJSON).build();
			}
			else
				response=Response.status(200).entity("No questions available").build();//Construir HTTP-RESPONSE con contenido de error

			return response;
		}
		
		@SuppressWarnings("unchecked")
		@GET
		@Produces(MediaType.APPLICATION_JSON)	
		@Path("/requestQuestionsByAppField")	
		public Response requestQuestions(@QueryParam("appField") String appField) {
			System.out.println("requestQuestionsByAppField: "+hsr.getRemoteAddr());
			Response response=null;
		
			/// El getResultLis hace que si esta vacio no se produzca una excepcion
			List<Question> questionList=(List<Question>)em.createNamedQuery("Question.findAppField").setParameter("appField", appField).getResultList();
			if(questionList.size()>0){//Si la lista de soluciones obtenida en la consulta es de 1 elemento
				List<QuestionJSON> questionJSONList = new ArrayList<QuestionJSON>();
				
				for(int i=0; i<questionList.size(); i++) {
					QuestionJSON questionJSON = new QuestionJSON(questionList.get(i).getIdQuestion(),questionList.get(i).getAnswer(),
							questionList.get(i).getAppField(),questionList.get(i).getOpt1(),questionList.get(i).getOpt2(),
							questionList.get(i).getOpt3(),questionList.get(i).getOpt4(),questionList.get(i).getWeight1(),
							questionList.get(i).getWeight2(),questionList.get(i).getWeight3(),questionList.get(i).getWeight4(),
							questionList.get(i).getWording());
					questionJSONList.add(questionJSON);
				}
				QuestionsJSON questionsJSON = new QuestionsJSON(questionJSONList);
				response=Response.status(200).entity(questionsJSON).build();
			}
			else
				response=Response.status(200).entity("No questions available").build();//Construir HTTP-RESPONSE con contenido de error

			return response;
		}
	
		
		@SuppressWarnings("unchecked")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)	
		@Path("/uploadQuestion")	
		public Response uploadSolution(QuestionJSON questionJSON) {
			System.out.println("uploadQuestion: "+hsr.getRemoteAddr());
			Response response=null;
			
			//Question question=em.find(Question.class, questionJSON.getIdQuestion());
			//if(question != null)
				//response=Response.status(200).entity("Question already exists").build();
			//else {
			
			Question question = new Question();
			
			question.setAnswer(questionJSON.getAnswer());
			question.setAppField(questionJSON.getAppField());
			question.setOpt1(questionJSON.getOpt1());
			question.setOpt2(questionJSON.getOpt2());
			question.setOpt3(questionJSON.getOpt3());
			question.setOpt4(questionJSON.getOpt4());
			question.setWeight1(questionJSON.getWeight1());
			question.setWeight2(questionJSON.getWeight2());
			question.setWeight3(questionJSON.getWeight3());
			question.setWeight4(questionJSON.getWeight4());
			question.setWording(questionJSON.getWording());
			
			em.persist(question);
			
			response=Response.status(200).entity("Question uploaded").build();
			//}
				
			
			
			return response;
		}
}



