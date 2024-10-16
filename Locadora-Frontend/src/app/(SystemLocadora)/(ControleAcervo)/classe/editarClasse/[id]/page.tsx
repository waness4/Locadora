"use client";

import { useClasseHook } from "@/hooks/classe";
import { FormNovaClasse } from "../../novaClasse/components/dialog-form-classe";
import { useEffect, useState } from "react";
import { Loader } from "lucide-react";

interface EditarClasseProps {
  id: string;
}

export default function EditarClasse({ id }: EditarClasseProps) {
  const { classe, selecionarClasse } = useClasseHook();
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        setIsLoading(true);
        setError(null); 
        await selecionarClasse(id);
      }catch (error){
        setError("Erro ao carregar os dados da classe.");
      } finally{
      setIsLoading(false);
      }
    };

    fetchData();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [id, selecionarClasse]);

  if (isLoading) {
    return (
      <div className="flex items-center justify-center gap-2 w-full">
        Carregando...
        {isLoading && <Loader className="mr-2 h-4 w-4 animate-spin" />}
      </div>
    );
  }

  if (error) {
    return (
      <div className="text-red-500 text-center">
        {error}
      </div>
    );
  }

  return (
    <div>
      {classe ? (
        <FormNovaClasse classe={classe} />
      ) : (
        <div className="text-center">Classe não encontrada.</div>
      )}
    </div>
  );
}
