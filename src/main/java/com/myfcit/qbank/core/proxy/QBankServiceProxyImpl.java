/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.proxy;

import com.myfcit.qbank.core.dtos.LoginRequestModel;
import com.myfcit.qbank.core.dtos.QuestionFilterRequestModel;
import com.myfcit.qbank.core.entities.AnswerEntity;
import com.myfcit.qbank.core.entities.ApplicationContentEntity;
import com.myfcit.qbank.core.entities.ChapterEntity;
import com.myfcit.qbank.core.entities.CloEntity;
import com.myfcit.qbank.core.entities.CourseEntity;
import com.myfcit.qbank.core.entities.ExamEntity;
import com.myfcit.qbank.core.entities.ExamSectionEntity;
import com.myfcit.qbank.core.entities.HvcloEntity;
import com.myfcit.qbank.core.entities.PermissionEntity;
import com.myfcit.qbank.core.entities.QuestionEntity;
import com.myfcit.qbank.core.entities.QuestionTypeEntity;
import com.myfcit.qbank.core.entities.RoleEntity;
import com.myfcit.qbank.core.entities.UserEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import com.myfcit.qbank.core.services.AnswerService;
import com.myfcit.qbank.core.services.ApplicationContentService;
import com.myfcit.qbank.core.services.ChapterService;
import com.myfcit.qbank.core.services.CloService;
import com.myfcit.qbank.core.services.CourseService;
import com.myfcit.qbank.core.services.ExamSectionService;
import com.myfcit.qbank.core.services.ExamService;
import com.myfcit.qbank.core.services.HvcloService;
import com.myfcit.qbank.core.services.PermissionService;
import com.myfcit.qbank.core.services.QuestionService;
import com.myfcit.qbank.core.services.QuestionTypeService;
import com.myfcit.qbank.core.services.RoleService;
import com.myfcit.qbank.core.services.UserService;
import java.util.List;
import javax.persistence.EntityManager;

public class QBankServiceProxyImpl implements QBankServiceableProxy {

    private EntityManager entityManager;

    public QBankServiceProxyImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public UserEntity findByUsernameAndPassword(LoginRequestModel loginRequestModel) throws QbankException {
        return new UserService(this.getEntityManager()).findByUsernameAndPassword(loginRequestModel);
    }

    @Override
    public List<UserEntity> findlAllUsers() throws QbankException {
        return new UserService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateUser(UserEntity userEntity) throws QbankException {
        new UserService(this.getEntityManager()).edit(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) throws QbankException {
        new UserService(this.getEntityManager()).remove(userEntity);
    }

    @Override
    public UserEntity findUserById(Object id) throws QbankException {
        return (UserEntity) new UserService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<UserEntity> findUsersByRange(int[] range) throws QbankException {
        return new UserService(this.getEntityManager()).findRange(range);
    }

    @Override
    public int countAllUser() throws QbankException {
        return new UserService(this.getEntityManager()).count();
    }

    @Override
    public List<CloEntity> findlAllClos() throws QbankException {
        return new CloService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateClo(CloEntity cloEntity) throws QbankException {
        new CloService(this.getEntityManager()).edit(cloEntity);
    }

    @Override
    public void deleteClo(CloEntity cloEntity) throws QbankException {
        new CloService(this.getEntityManager()).remove(cloEntity);
    }

    @Override
    public CloEntity findCloById(Object id) throws QbankException {
        return (CloEntity) new CloService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<CloEntity> findClosByRange(int[] range) throws QbankException {
        return new CloService(this.getEntityManager()).findRange(range);
    }

    @Override
    public int countAllClos() throws QbankException {
        return new CloService(this.getEntityManager()).count();
    }

    @Override
    public List<CourseEntity> findlAllCourses() throws QbankException {
        return new CourseService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateCourse(CourseEntity courseEntity) throws QbankException {
        new CourseService(this.getEntityManager()).edit(courseEntity);
    }

    @Override
    public void deleteCourse(CourseEntity courseEntity) throws QbankException {
        new CourseService(this.getEntityManager()).remove(courseEntity);
    }

    @Override
    public CourseEntity findCourseById(Object id) throws QbankException {
        return (CourseEntity) new CourseService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<CourseEntity> findCoursesByRange(int[] range) throws QbankException {
        return new CourseService(this.getEntityManager()).findRange(range);
    }

    @Override
    public int countAllClourses() throws QbankException {
        return new CourseService(this.getEntityManager()).count();
    }

    @Override
    public List<ChapterEntity> findlAllChapters() throws QbankException {
        return new ChapterService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateChapter(ChapterEntity chapterEntity) throws QbankException {
        new ChapterService(this.getEntityManager()).edit(chapterEntity);
    }

    @Override
    public void deleteChapter(ChapterEntity chapterEntity) throws QbankException {
        new ChapterService(this.getEntityManager()).remove(chapterEntity);
    }

    @Override
    public ChapterEntity findChapterById(Object id) throws QbankException {
        return (ChapterEntity) new ChapterService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<ChapterEntity> findChaptersByRange(int[] range) throws QbankException {
        return new ChapterService(this.getEntityManager()).findRange(range);
    }

    @Override
    public int countAllChapters() throws QbankException {
        return new ChapterService(this.getEntityManager()).count();
    }

    @Override
    public void addUser(UserEntity userEntity) throws QbankException {
        new UserService(this.getEntityManager()).create(userEntity);
    }

    @Override
    public void addChapter(ChapterEntity chapterEntity) throws QbankException {
        new ChapterService(this.getEntityManager()).create(chapterEntity);
    }

    @Override
    public void addCourse(CourseEntity courseEntity) throws QbankException {
        new CourseService(this.getEntityManager()).create(courseEntity);
    }

    @Override
    public void addClo(CloEntity cloEntity) throws QbankException {
        new CloService(this.getEntityManager()).create(cloEntity);
    }

    @Override
    public List<ExamEntity> findlAllExams() throws QbankException {
        return new ExamService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateExam(ExamEntity examEntity) throws QbankException {
        new ExamService(this.getEntityManager()).edit(examEntity);
    }

    @Override
    public void addExam(ExamEntity ExamEntity) throws QbankException {
        new ExamService(this.getEntityManager()).create(ExamEntity);
    }

    @Override
    public void deleteExam(ExamEntity ExamEntity) throws QbankException {
        new ExamService(this.getEntityManager()).remove(ExamEntity);
    }

    @Override
    public void deleteAnswer(AnswerEntity answeEntity) throws QbankException {
        new AnswerService(this.getEntityManager()).remove(answeEntity);
    }

    @Override
    public ExamEntity findExamById(Object id) throws QbankException {
        return (ExamEntity) new ExamService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<ExamSectionEntity> findlAllExamSections() throws QbankException {
        return new ExamSectionService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateExamSection(ExamSectionEntity examSectionEntity) throws QbankException {
        new ExamSectionService(this.getEntityManager()).edit(examSectionEntity);
    }

    @Override
    public void addExamSection(ExamSectionEntity examSectionEntity) throws QbankException {
        new ExamSectionService(this.getEntityManager()).create(examSectionEntity);
    }

    @Override
    public void deleteExamSection(ExamSectionEntity examSectionEntity) throws QbankException {
        new ExamSectionService(this.getEntityManager()).remove(examSectionEntity);
    }

    @Override
    public ExamSectionEntity findExamSectionById(Object id) throws QbankException {
        return (ExamSectionEntity) new ExamSectionService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<QuestionEntity> findlAllQuestions() throws QbankException {
        return new QuestionService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateQuestion(QuestionEntity questionEntity) throws QbankException {
        new QuestionService(this.getEntityManager()).edit(questionEntity);
    }

    @Override
    public void addQuestion(QuestionEntity questionEntity) throws QbankException {
        new QuestionService(this.getEntityManager()).create(questionEntity);
    }

    @Override
    public void deleteQuestion(QuestionEntity questionEntity) throws QbankException {
        new QuestionService(this.getEntityManager()).remove(questionEntity);
    }

    @Override
    public QuestionEntity findQuestionById(Object id) throws QbankException {
        return (QuestionEntity) new QuestionService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<QuestionTypeEntity> findlAllQuestionTypes() throws QbankException {
        return new QuestionTypeService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException {
        new QuestionTypeService(this.getEntityManager()).edit(questionTypeEntity);
    }

    @Override
    public void addQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException {
        new QuestionTypeService(this.getEntityManager()).create(questionTypeEntity);
    }

    @Override
    public void deleteQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException {
        new QuestionTypeService(this.getEntityManager()).remove(questionTypeEntity);
    }

    @Override
    public QuestionTypeEntity findQuestionTypeById(Object id) throws QbankException {
        return (QuestionTypeEntity) new QuestionTypeService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<RoleEntity> findlAllRoles() throws QbankException {
        return new RoleService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateRole(RoleEntity roleEntity) throws QbankException {
        new RoleService(this.getEntityManager()).edit(roleEntity);
    }

    @Override
    public void addRole(RoleEntity roleEntity) throws QbankException {
        new RoleService(this.getEntityManager()).create(roleEntity);
    }

    @Override
    public void deleteRole(RoleEntity roleEntity) throws QbankException {
        new RoleService(this.getEntityManager()).remove(roleEntity);
    }

    @Override
    public RoleEntity findRoleById(Object id) throws QbankException {
        return (RoleEntity) new RoleService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<PermissionEntity> findlAllPermissions() throws QbankException {
        return new PermissionService(this.getEntityManager()).findAll();
    }

    @Override
    public void updatePermission(PermissionEntity permissionEntity) throws QbankException {
        new PermissionService(this.getEntityManager()).edit(permissionEntity);
    }

    @Override
    public void addPermission(PermissionEntity permissionEntity) throws QbankException {
        new PermissionService(this.getEntityManager()).create(permissionEntity);
    }

    @Override
    public void deletePermission(PermissionEntity permissionEntity) throws QbankException {
        new PermissionService(this.getEntityManager()).remove(permissionEntity);
    }

    @Override
    public PermissionEntity findPermissionById(Object id) throws QbankException {
        return (PermissionEntity) new PermissionService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<HvcloEntity> findlAllHvclos() throws QbankException {
        return new HvcloService(this.getEntityManager()).findAll();
    }

    @Override
    public HvcloEntity findHvcloById(Object id) throws QbankException {
        return (HvcloEntity) new HvcloService(this.getEntityManager()).findById(id);
    }

    @Override
    public List<ApplicationContentEntity> findlAllApplicationContents() throws QbankException {
        return new ApplicationContentService(this.getEntityManager()).findAll();
    }

    @Override
    public void updateApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException {
        new ApplicationContentService(this.getEntityManager()).edit(applicationContentEntity);
    }

    @Override
    public void addApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException {
        new ApplicationContentService(this.getEntityManager()).create(applicationContentEntity);
    }

    @Override
    public void deleteApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException {
        new ApplicationContentService(this.getEntityManager()).remove(applicationContentEntity);
    }

    @Override
    public ApplicationContentEntity findApplicationContentById(Object id) throws QbankException {
        return (ApplicationContentEntity) new ApplicationContentService(this.getEntityManager()).findById(id);

    }

    @Override
    public List<UserEntity> findAllLectures() throws QbankException {
        return new UserService(this.getEntityManager()).findAllLectures();
    }

    @Override
    public List<CourseEntity> findAllLecturesCourses(int lecturerId) throws QbankException {
        return new CourseService(this.getEntityManager()).findAllLecturesCourses(lecturerId);
    }

    @Override
    public UserEntity findByUserName(String userName) throws QbankException {
        return new UserService(this.getEntityManager()).findByUsername(userName);
    }

    @Override
    public CourseEntity findByCourseName(Object courseName) throws QbankException {
        return new CourseService(this.getEntityManager()).findByCourseName(courseName);
    }

//    @Override
//    public List<HvcloEntity> findHvcloByCourseId(Object courseId) throws QbankException {
//         return hvcloService.findHvcloByCourseId(courseId);
//    }
// 
    @Override
    public List<HvcloEntity> findHvcloByCourseId(int courseId) throws QbankException {
        return new HvcloService(this.getEntityManager()).findHvcloByCourseId(courseId);
    }

    @Override

    public AnswerEntity findByAnswerId(int ansId) throws QbankException {
        return (AnswerEntity) new AnswerService(this.getEntityManager()).findById(ansId);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<QuestionEntity> findAllQuestionByCourseId(int courseId) throws QbankException {
        return new QuestionService(this.getEntityManager()).findAllQuestionByCourseId(courseId);
    }

    @Override
    public List<ExamSectionEntity> findAllExamSectionsByExamId(int examId) throws QbankException {
        return new ExamSectionService(this.getEntityManager()).findAllExamSectionsByExamId(examId);
    }

    @Override
    public List<QuestionEntity> searchForQuestions(QuestionFilterRequestModel questionFilterRequestModel) throws QbankException {
        return new QuestionService(this.getEntityManager()).searchForQuestions(questionFilterRequestModel);
    }

    @Override
    public List<ExamEntity> findAllLecturesExams(int lecturerId) throws QbankException {
        return new ExamService(this.getEntityManager()).findAllLecturesExams(lecturerId);
    }

}
