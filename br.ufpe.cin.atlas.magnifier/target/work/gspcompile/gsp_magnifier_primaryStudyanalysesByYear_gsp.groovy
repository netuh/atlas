import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_primaryStudyanalysesByYear_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/primaryStudy/analysesByYear.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
for( studyType in (list) ) {
printHtmlPart(2)
for( studyYear in (studyType.value) ) {
printHtmlPart(3)
expressionOut.print(studyYear.key)
printHtmlPart(4)
expressionOut.print(studyYear.value.size())
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(studyType.key)
printHtmlPart(7)
expressionOut.print(studyType.key)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('captureMeta','sitemesh',33,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(9)
invokeTag('set','g',35,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(9)
createTagBody(2, {->
createClosureForHtmlPart(10, 3)
invokeTag('captureTitle','sitemesh',36,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',36,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',37,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(11)
invokeTag('message','g',40,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(12)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(13)
invokeTag('message','g',44,['code':("default.home.label")],-1)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
if(true && (conference == 'EASE')) {
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (conference == 'ESEM')) {
printHtmlPart(16)
}
printHtmlPart(18)
if(true && (conference == 'ESEJ')) {
printHtmlPart(16)
}
printHtmlPart(19)
if(true && (conference == null || conference == 'All')) {
printHtmlPart(16)
}
printHtmlPart(20)
invokeTag('actionSubmit','g',59,['action':("analysesByYear"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(21)
})
invokeTag('form','g',60,['controller':("primaryStudy")],2)
printHtmlPart(22)
for( study in (list) ) {
printHtmlPart(23)
expressionOut.print(study.key)
printHtmlPart(24)
expressionOut.print(study.key)
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',71,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1384359939000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
