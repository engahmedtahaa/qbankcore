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
import java.util.List;

public interface QBankServiceableProxy {

    public UserEntity findByUsernameAndPassword(LoginRequestModel loginRequestModel) throws QbankException;

    public List<UserEntity> findlAllUsers() throws QbankException;

    public void updateUser(UserEntity userEntity) throws QbankException;

    public void addUser(UserEntity userEntity) throws QbankException;

    public void deleteUser(UserEntity userEntity) throws QbankException;

    public UserEntity findUserById(Object id) throws QbankException;

    public List<UserEntity> findUsersByRange(int[] range) throws QbankException;

    public int countAllUser() throws QbankException;

    public List<CloEntity> findlAllClos() throws QbankException;

    public void updateClo(CloEntity cloEntity) throws QbankException;

    public void deleteClo(CloEntity cloEntity) throws QbankException;

    public CloEntity findCloById(Object id) throws QbankException;

    public List<CloEntity> findClosByRange(int[] range) throws QbankException;

    public int countAllClos() throws QbankException;

    public List<CourseEntity> findlAllCourses() throws QbankException;

    public CourseEntity findByCourseName(Object courseName) throws QbankException;

    public void updateCourse(CourseEntity courseEntity) throws QbankException;

    public void deleteCourse(CourseEntity courseEntity) throws QbankException;

    public CourseEntity findCourseById(Object id) throws QbankException;

    public List<CourseEntity> findCoursesByRange(int[] range) throws QbankException;

    public int countAllClourses() throws QbankException;

    public List<ChapterEntity> findlAllChapters() throws QbankException;

    public void updateChapter(ChapterEntity chapterEntity) throws QbankException;

    public void deleteChapter(ChapterEntity chapterEntity) throws QbankException;

    public ChapterEntity findChapterById(Object id) throws QbankException;

    public List<ChapterEntity> findChaptersByRange(int[] range) throws QbankException;

    public int countAllChapters() throws QbankException;

    public void addChapter(ChapterEntity chapterEntity) throws QbankException;

    public void addCourse(CourseEntity courseEntity) throws QbankException;

    public void addClo(CloEntity cloEntity) throws QbankException;

    public List<ExamEntity> findlAllExams() throws QbankException;

    public void updateExam(ExamEntity examEntity) throws QbankException;

    public void addExam(ExamEntity ExamEntity) throws QbankException;

    public void deleteExam(ExamEntity ExamEntity) throws QbankException;

    public ExamEntity findExamById(Object id) throws QbankException;

    public List<ExamSectionEntity> findlAllExamSections() throws QbankException;

    public void updateExamSection(ExamSectionEntity examSectionEntity) throws QbankException;

    public void addExamSection(ExamSectionEntity examSectionEntity) throws QbankException;

    public void deleteExamSection(ExamSectionEntity examSectionEntity) throws QbankException;

    public ExamSectionEntity findExamSectionById(Object id) throws QbankException;

    public List<QuestionEntity> findlAllQuestions() throws QbankException;

    public void updateQuestion(QuestionEntity questionEntity) throws QbankException;

    public void addQuestion(QuestionEntity questionEntity) throws QbankException;

    public void deleteQuestion(QuestionEntity questionEntity) throws QbankException;

    public QuestionEntity findQuestionById(Object id) throws QbankException;

    public List<QuestionTypeEntity> findlAllQuestionTypes() throws QbankException;

    public void updateQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException;

    public void addQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException;

    public void deleteQuestionType(QuestionTypeEntity questionTypeEntity) throws QbankException;

    public QuestionTypeEntity findQuestionTypeById(Object id) throws QbankException;

    public List<RoleEntity> findlAllRoles() throws QbankException;

    public void updateRole(RoleEntity roleEntity) throws QbankException;

    public void addRole(RoleEntity roleEntity) throws QbankException;

    public void deleteRole(RoleEntity roleEntity) throws QbankException;

    public RoleEntity findRoleById(Object id) throws QbankException;

    public List<PermissionEntity> findlAllPermissions() throws QbankException;

    public void updatePermission(PermissionEntity permissionEntity) throws QbankException;

    public void addPermission(PermissionEntity permissionEntity) throws QbankException;

    public void deletePermission(PermissionEntity permissionEntity) throws QbankException;

    public PermissionEntity findPermissionById(Object id) throws QbankException;

    public List<HvcloEntity> findlAllHvclos() throws QbankException;

    public HvcloEntity findHvcloById(Object id) throws QbankException;

    public List<ApplicationContentEntity> findlAllApplicationContents() throws QbankException;

    public void updateApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException;

    public void addApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException;

    public void deleteApplicationContent(ApplicationContentEntity applicationContentEntity) throws QbankException;

    public ApplicationContentEntity findApplicationContentById(Object id) throws QbankException;

    public List<UserEntity> findAllLectures() throws QbankException;

    public UserEntity findByUserName(String userName) throws QbankException;

    public List<HvcloEntity> findHvcloByCourseId(int courseId) throws QbankException;

    public List<CourseEntity> findAllLecturesCourses(int lecturerId) throws QbankException;

    public AnswerEntity findByAnswerId(int ansId) throws QbankException;

    public List<QuestionEntity> findAllQuestionByCourseId(int courseId) throws QbankException;

    public List<ExamSectionEntity> findAllExamSectionsByExamId(int examId) throws QbankException;

    public void deleteAnswer(AnswerEntity answeEntity) throws QbankException;

    public List<QuestionEntity> searchForQuestions(QuestionFilterRequestModel questionFilterRequestModel) throws QbankException;

    public List<ExamEntity> findAllLecturesExams(int lecturerId) throws QbankException;
}
