PDF = aisd.pdf
TEX = aisd.tex
RM = rm

default: $(PDF)
	evince $(PDF)

$(PDF): $(TEX)
	pdflatex $(TEX)

clean:
	$(RM) $(PDF)
	
	
