import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_magnifier_mechanismanalyseByEmpiricalMethod_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mechanism/analyseByEmpiricalMethod.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
for( study in (list) ) {
printHtmlPart(2)
expressionOut.print(study.key)
printHtmlPart(3)
expressionOut.print(study.value.size())
printHtmlPart(4)
}
printHtmlPart(5)
invokeTag('captureMeta','sitemesh',25,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(6)
invokeTag('set','g',27,['var':("entityName"),'value':(message(code: 'primaryStudy.label', default: 'PrimaryStudy'))],-1)
printHtmlPart(6)
createTagBody(2, {->
createClosureForHtmlPart(7, 3)
invokeTag('captureTitle','sitemesh',28,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',28,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',29,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(8)
invokeTag('message','g',31,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(9)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(10)
invokeTag('message','g',34,['code':("default.home.label")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('actionSubmit','g',45,['action':("analyseByEmpiricalMethod"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(13)
})
invokeTag('form','g',46,['controller':("mechanism")],2)
printHtmlPart(14)
invokeTag('message','g',50,['code':("primaryStudy.byType.label"),'default':("Primary Studies by Study Type")],-1)
printHtmlPart(15)
for( study in (list) ) {
printHtmlPart(16)
expressionOut.print(study.key)
printHtmlPart(17)
for( aStudy in (study.value) ) {
printHtmlPart(18)
expressionOut.print(aStudy.getContent())
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1384269204000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
