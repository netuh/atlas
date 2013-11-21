import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_badMechanismanalysesStudyType_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/badMechanism/analysesStudyType.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(studyType)
printHtmlPart(2)
expressionOut.print(allStudies.size()-withMechism.size())
printHtmlPart(3)
expressionOut.print(studyType)
printHtmlPart(4)
expressionOut.print(withGuideline.size())
printHtmlPart(3)
expressionOut.print(studyType)
printHtmlPart(5)
expressionOut.print(withMechism.size()-withGuideline.size())
printHtmlPart(6)
expressionOut.print(studyType)
printHtmlPart(7)
expressionOut.print(allStudies.size()-withMechism.size())
printHtmlPart(8)
expressionOut.print(withMechism.size())
printHtmlPart(9)
expressionOut.print(studyType)
printHtmlPart(10)
expressionOut.print(allStudies.size()-withGuideline.size())
printHtmlPart(11)
expressionOut.print(withGuideline.size())
printHtmlPart(9)
expressionOut.print(studyType)
printHtmlPart(12)
invokeTag('captureMeta','sitemesh',61,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(13)
invokeTag('set','g',63,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(13)
createTagBody(2, {->
createClosureForHtmlPart(14, 3)
invokeTag('captureTitle','sitemesh',64,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',64,[:],2)
printHtmlPart(13)
})
invokeTag('captureHead','sitemesh',65,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(15)
invokeTag('message','g',68,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(16)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(17)
invokeTag('message','g',72,['code':("default.home.label")],-1)
printHtmlPart(18)
createTagBody(2, {->
invokeTag('message','g',73,['code':("default.Mechanism.label"),'default':("Mechanism")],-1)
})
invokeTag('link','g',73,['class':("list"),'action':("index")],2)
printHtmlPart(19)
invokeTag('message','g',78,['code':("primaryStudy.byType.label"),'default':("Complete Graph about ${studyType}")],-1)
printHtmlPart(20)
invokeTag('message','g',83,['code':("primaryStudy.byType.label"),'default':("With Mechanism")],-1)
printHtmlPart(21)
for( study in (withMechism) ) {
printHtmlPart(22)
expressionOut.print(study.getStudyId())
printHtmlPart(23)
expressionOut.print(study.getTitle())
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('message','g',96,['code':("primaryStudy.byType.label"),'default':("With Guideline")],-1)
printHtmlPart(26)
for( study in (withGuideline) ) {
printHtmlPart(22)
expressionOut.print(study.getStudyId())
printHtmlPart(23)
expressionOut.print(study.getTitle())
printHtmlPart(24)
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1384370414000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
