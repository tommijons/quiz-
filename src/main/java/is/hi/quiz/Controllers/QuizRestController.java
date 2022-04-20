package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Account;
import is.hi.quiz.Persistance.Entities.Category;
import is.hi.quiz.Persistance.Entities.Question;
import is.hi.quiz.Persistance.Entities.Scores;
import is.hi.quiz.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizRestController {
    private QuizService quizService;

    @Autowired
    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/questions")
    public List<Question> getQuestions() throws InterruptedException {
        List<Question> questions = quizService.findAll();

        return questions;
    }

    @RequestMapping("/questions/{id}")
    public List<Question> getQuestionByCategory(@PathVariable(value="id") int id) throws InterruptedException {
        List<Question> questionsByCat = quizService.findByCategory(id);
        return questionsByCat;

    }

    @RequestMapping(value="/deleteQuestion/{id}",method = RequestMethod.DELETE)
    public String deleteQuestion(@PathVariable("id")long id){
        Question questionToDelete = quizService.findById(id);
        quizService.delete(questionToDelete);
        return null;
    }

    @RequestMapping("/categories")
    public List<Category> getCategories() {
        List<Category> categories = quizService.findAllCategories();

        return categories;
    }

    // Returns top scores for all time high scorers
    @RequestMapping(value = "/topscoresAPI", method = RequestMethod.GET)
    public List<Scores> getTopScores() {
        List <Scores> scores = quizService.findAllScores();
        return scores;
    }

    // save score
    @PostMapping("/saveScore")
    Scores score(@RequestBody Scores score) {
        return quizService.saveScores(score);
    }


}
