PDF = aisd.pdf
TEX = aisd.tex
RM = rm

default: $(PDF)
	evince $(PDF)

$(PDF): $(TEX)
	pdflatex $(TEX)

clean:
	rm $(PDF) *.log *.out *.toc *.aux
