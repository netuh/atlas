package br.ufpe.cin.atlas.magnifier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SourceInstitutionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SourceInstitution.list(params), model:[sourceInstitutionInstanceCount: SourceInstitution.count()]
    }

    def show(SourceInstitution sourceInstitutionInstance) {
        respond sourceInstitutionInstance
    }

    def create() {
        respond new SourceInstitution(params)
    }

    @Transactional
    def save(SourceInstitution sourceInstitutionInstance) {
        if (sourceInstitutionInstance == null) {
            notFound()
            return
        }

        if (sourceInstitutionInstance.hasErrors()) {
            respond sourceInstitutionInstance.errors, view:'create'
            return
        }

        sourceInstitutionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sourceInstitutionInstance.label', default: 'SourceInstitution'), sourceInstitutionInstance.id])
                redirect sourceInstitutionInstance
            }
            '*' { respond sourceInstitutionInstance, [status: CREATED] }
        }
    }

    def edit(SourceInstitution sourceInstitutionInstance) {
        respond sourceInstitutionInstance
    }

    @Transactional
    def update(SourceInstitution sourceInstitutionInstance) {
        if (sourceInstitutionInstance == null) {
            notFound()
            return
        }

        if (sourceInstitutionInstance.hasErrors()) {
            respond sourceInstitutionInstance.errors, view:'edit'
            return
        }

        sourceInstitutionInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SourceInstitution.label', default: 'SourceInstitution'), sourceInstitutionInstance.id])
                redirect sourceInstitutionInstance
            }
            '*'{ respond sourceInstitutionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SourceInstitution sourceInstitutionInstance) {

        if (sourceInstitutionInstance == null) {
            notFound()
            return
        }

        sourceInstitutionInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SourceInstitution.label', default: 'SourceInstitution'), sourceInstitutionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sourceInstitutionInstance.label', default: 'SourceInstitution'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
