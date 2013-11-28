import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_badMechanismindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/badMechanism/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
if(true && (conference == 'EASE')) {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (conference == 'ESEM')) {
printHtmlPart(8)
}
printHtmlPart(10)
if(true && (conference == 'ESEJ')) {
printHtmlPart(8)
}
printHtmlPart(11)
if(true && (conference == null || conference == 'All')) {
printHtmlPart(8)
}
printHtmlPart(12)
for( aStudyType in (list) ) {
printHtmlPart(13)
expressionOut.print(aStudyType)
printHtmlPart(5)
expressionOut.print(aStudyType)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('actionSubmit','g',35,['action':("analysesStudyType"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(16)
})
invokeTag('form','g',36,['controller':("badMechanism")],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',1,[:],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385146250000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
